#lang racket
(require 2htdp/image)
(require 2htdp/universe)
 
(define WIDTH 300)
(define DELTA 3)
(define BALL (circle 5 "solid" "red"))
(define MT   (empty-scene WIDTH 10))
 
(define (main x0)
  (big-bang x0
    [to-draw render]
    [on-tick bounce]))
 
(define (bounce x)
  (cond
    [(>= x 0)
     (cond
       [(> (+ x DELTA) WIDTH) (- WIDTH)]
       [else (+ x DELTA)])]
    [(<= x 0)
     (cond
       [(> (+ DELTA x) 0) 0]
       [else (+ DELTA x)])]))
 
(define (render x)
  (place-image BALL (abs x) 5 MT))