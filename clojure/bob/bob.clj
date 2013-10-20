(ns bob)

(defn question? [s]
  (= \? (last s)))

(defn said-words? [s]
  (re-find #"[a-zA-Z]" s))

(defn shouting? [s]
  (and (said-words? s) (not (re-find #"[a-z]" s))))

(defn silence? [s]
  (re-matches #"\s*" s))

(defn response-for [statement]
  (cond
    (silence? statement) "Fine. Be that way!"
    (shouting? statement) "Woah, chill out!"
    (question? statement) "Sure."
    :else "Whatever."
    ))

