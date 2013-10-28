(ns phrase)

(defn- generate-words [s]
  "Returns a lazy sequence of words, consisting of unicode
  letters or digits, in string."
  (re-seq #"\p{L}+|\d+" (.toLowerCase s)))

(defn word-count [s]
  (frequencies (generate-words s)))
