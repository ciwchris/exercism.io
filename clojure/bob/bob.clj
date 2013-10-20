(ns bob)

(defn question? [s]
  (= \? (last s)))

(defn shouting? [s]
  (and
    (= (clojure.string/upper-case s) s)
    (not (= (clojure.string/lower-case s) s))))

(defn silence? [s]
  (clojure.string/blank? s))

(defn response-for [statement]
  (cond
    (silence? statement) "Fine. Be that way!"
    (shouting? statement) "Woah, chill out!"
    (question? statement) "Sure."
    :else "Whatever."))

