#lang racket

(define (mul10 num res) (* (+ res (modulo num 10)) 10))

(define (reverse-num num res)
  (cond
    [(< num 10) (+ res num)]
    [else
     (reverse-num (floor (/ num 10)) (mul10 num res) )]
    ))

(define (is-palindrome num)
  (cond
    [(< num 0) false]
    [(< num 10) true]
    [(= (modulo num 10) 0) false]
    [(= num (reverse-num num 0)) true]
    [else false]
    ))

(reverse-num 10 0)
(reverse-num 11 0)
(reverse-num 21 0)
(reverse-num 34445 0)
(reverse-num 34443 0)
(is-palindrome 121)
(is-palindrome -121)
(is-palindrome 10)
(is-palindrome 1)
(is-palindrome 34443)