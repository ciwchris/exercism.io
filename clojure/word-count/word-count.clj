(ns phrase)

(defn- format-word [s]
  (clojure.string/replace (.toLowerCase s) #"[^\p{L}\d]" ""))

(defn- generate-words [s]
  (remove empty? (map
                   format-word
                   (re-seq #"[^\s]+" s))))

(defn word-count [s]
  (frequencies (generate-words s)))
