(ns phrase)

(defn- create-key-name [word]
  (apply str (keep
               #(if (or (Character/isDigit %) (Character/isLetter %))
                  (Character/toLowerCase %))
               word)))

(defn- increment-word-count [key-name word-list]
  (let [word (keyword key-name)] 
    (if (word word-list)
      (assoc word-list word (inc (word word-list)))
      (assoc word-list word 1))))

(defn- create-keyword-map [word-list words]
  (if (empty? words)
    word-list
    (let [key-name (create-key-name (first words))] 
      (if (empty? key-name)
        (recur word-list (rest words))
        (recur (increment-word-count key-name word-list) (rest words)))))) 

(defn word-count [s]
  (into {} 
        (for [[k v] (create-keyword-map {} (clojure.string/split s #"\s+")) ] 
          [(name k) v])))
