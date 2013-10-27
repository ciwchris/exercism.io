(ns dna)

(defn- transcribe-nucleotide [s]
  (if (= s \T) \U s))

(defn to-rna [s]
  (apply str (map transcribe-nucleotide s)))
