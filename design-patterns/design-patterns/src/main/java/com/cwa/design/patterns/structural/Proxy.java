package com.cwa.design.patterns.structural;

public class Proxy {
/*
    Definition - Proxy Pattern creates an intermediate object that acts on behalf of the real object.

Simple Visualization

@Transactional

Client
   |
   v
Proxy
   |
   | Start Transaction
   v
Service Method
   |
   | Commit/Rollback
   v
Return

@Cacheable

Client
   |
   v
Proxy
   |
   | Check Cache
   |
   |---- Found ?
   |         |
   |        YES --> Return Cached Value
   |
   NO
   |
   v
Service Method
   |
   v
Store Result In Cache
   |
   v
Return
    */
}
