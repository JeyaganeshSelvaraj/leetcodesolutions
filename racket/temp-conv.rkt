#lang racket

(define (f2c f) (* 5/9 (- f 32)))

(define (c2f c) (+ (* 9/5 c) 32))


(= (f2c -40) -40)
(= (f2c 32) 0)
(= (f2c 212) 100)
