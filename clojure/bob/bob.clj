(ns bob)

(defn question? [s]
  (= \? (.charAt s (- (.length s) 1))))

(defn said-words? [s]
  (not (nil? (re-find #"[a-zA-Z]" s))))

(defn shouting? [s]
  (and (said-words? s) (nil? (re-find #"[a-z]" s))))

(defn silence? [s]
  (not (nil? (re-matches #"\s*" s))))

(defn response-for [statement]
  (cond
    (silence? statement) "Fine. Be that way!"
    (shouting? statement) "Woah, chill out!"
    (question? statement) "Sure."
    :else "Whatever."
    ))

