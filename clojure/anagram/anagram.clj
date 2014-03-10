(ns anagram
  (require [clojure.string :refer [lower-case]]))

(defn- anagram? [word letter-counts potential-anagram]
  (let [potential-anagram (lower-case potential-anagram)]
    (and
      (not= word potential-anagram)
      (= letter-counts (frequencies potential-anagram)))))

(defn anagrams-for [word word-list]
  (let [word (lower-case word)
        letter-counts (frequencies word)]
    (filter #(anagram? word letter-counts %) word-list)))

