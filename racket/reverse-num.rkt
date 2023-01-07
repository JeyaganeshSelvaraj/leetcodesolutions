#lang racket
(define (mul10 num res) (* (+ res (modulo num 10)) 10))

(define (reverse-num num res)
  (cond
    [(not-in-range res) 0]
    [(< num 10) (+ res num)]
    [else
     (reverse-num (floor (/ num 10)) (mul10 num res) )]
    ))

(define MAX  (expt 2 31 ) )
(define MIN  (- MAX))
(define (not-in-range num)
  (cond
    [(>= num MAX) true]
    [(< num MIN)  true]
    [else false]))


(define (reverse num)
  (cond
    [(not-in-range num) 0]        
    [(< num 0)
      (if (> num -10)
          num
          (- (reverse-num (abs num) 0)))]
    [(< num 10) num]
    [else (reverse-num num 0)]))

(= (reverse 0) 0)
(= (reverse 123) 321)
(= (reverse -123) -321)
(= (reverse MAX) 0)
(= (reverse MIN) 0)
(= (reverse 1534236469) 0)