(ns anagram)

(defn- anagram? [s item]
  (and
    (not= s item)
    (= (frequencies s) (frequencies item))))

(defn anagrams-for [s c]
  (let [text (clojure.string/lower-case s)]
    (filter #(anagram?
               text
               (clojure.string/lower-case %)) c)))

