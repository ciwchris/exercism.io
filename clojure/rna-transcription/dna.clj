(ns dna)

(defn- transcribe-nucleotide [s]
  (if (= s \T) \U s))

(defn- transcribe-rna [s transcription]
  (if (empty? s)
    transcription
    (recur
      (rest s)
      (conj transcription (transcribe-nucleotide (first s))))))

(defn to-rna [s]
  (apply str (transcribe-rna s [])))
