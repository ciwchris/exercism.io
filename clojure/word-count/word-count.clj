(ns phrase)

(defn- format-word [s]
  "Returns string in lower case form with any characters
  which are not unicode letters or digits removed."
  (clojure.string/replace (.toLowerCase s) #"[^\p{L}\d]" ""))

(defn- generate-words [s]
  "Returns a lazy sequence of words in string."
  (remove empty? (map
                   format-word
                   (re-seq #"[^\s]+" s))))

(defn word-count [s]
  (frequencies (generate-words s)))
