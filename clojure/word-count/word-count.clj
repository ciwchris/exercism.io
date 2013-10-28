(ns phrase)

(defn- map-word-to-word-list [word-list word]
  (assoc word-list word (inc (word-list word 0))))

(defn- generate-words [s]
  ; A word can consist of unicode letters or digits
  (re-seq #"\p{L}+|\d+" (.toLowerCase s)))

(defn word-count [s]
  (reduce map-word-to-word-list
          {}
          (generate-words s)))
