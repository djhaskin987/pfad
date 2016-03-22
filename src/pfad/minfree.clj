(ns pfad.minfree)


(defn minfrom [a n x]
  (if (= 0 n)
    a
    (let [b (+ 1 (quot n 2) a)
          {us true vs false} (group-by #(< % b) x)
          m (count us)]
      (if (= m (- b a))
        (minfrom b (- n m) vs)
        (minfrom a m us)))))

(defn minfree
  "Find the smallest natural number in a list."
  [x]
  (minfrom 0 (count x) x))

(defn checklist [x]
  (let [c (count x)
        result (transient (vec (repeat c false)))]
   (doseq [e x]
     (when (< e c)
       (assoc! result e true)))
   (persistent! result)))

(defn search [x]
  (first (keep-indexed #(when (not %2) %1) x)))

; Interestingly, the book says the other (divide/conquer alg) alg beats this
; one by about 20% in Haskell.  In Clojure, I can use transients here (see
; the checklist method). In benchmarks, this function *destroys* the other
; one, something like a 2x increase in speed. It can also handle multiple
; elements.
(defn minfree-multi
  "Find the smallest natural number in a set,
  where the elements of the list are not guaranteed to be unique."
  [X]
  (let [search-result  (search (checklist X))]
    (if search-result
      search-result
      (count X))))
