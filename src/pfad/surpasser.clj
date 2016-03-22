(ns pfad.surpasser)


; This function is used everywhere in the pearl, so I'm just gonna define it here.
(defn tails [sq]
  (if (empty? sq)
    sq
    (cons [(first sq) (rest sq)] (tails (rest sq)))))


(defn msc [sq] (count sq))

