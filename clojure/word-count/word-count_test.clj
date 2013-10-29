(ns word-count.test (:require [clojure.test :refer :all]))
(load-file "word-count.clj")

(deftest count-one-word
  (is (= {"word" 1}
         (phrase/word-count "word"))))

(deftest count-one-of-each
  (is (= {"one" 1 "of" 1 "each" 1}
         (phrase/word-count "one of each"))))

(deftest count-multiple-occurrences
  (is (= {"one" 1 "fish" 4 "two" 1 "red" 1 "blue" 1}
         (phrase/word-count "one fish two fish red fish blue fish"))))

(deftest ignore-punctuation
  (is (= {"car" 1, "carpet" 1 "as" 1 "java" 1 "javascriptz" 1}
         (phrase/word-count "car : carpet as java : javascript!!&@$%^&z"))))

(deftest word-with-punctuation
  (is (= {"cant" 1}
         (phrase/word-count "can't"))))

(deftest word-with-number
  (is (= {"word1two" 1}
         (phrase/word-count "word1two"))))

(deftest include-high-bit-ascii
  (is (= {"äüö" 1}
         (phrase/word-count "ÄÜÖ"))))

(deftest include-numbers
  (is (= {"testing" 2 "1" 1 "2" 1}
         (phrase/word-count "testing, 1, 2 testing"))))

(deftest normalize-case
  (is (= {"go" 3}
         (phrase/word-count "go Go GO"))))

(run-tests)
