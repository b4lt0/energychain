import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Packet } from '../_models/packet.model';
import { Transaction } from '../_models/transaction.model';
import { Observable } from 'rxjs';
import { User } from '../_models/user.model';
import { Type } from '@angular/compiler/src/core';
import { Time } from '@angular/common';

const API_URL = 'http://localhost:8080/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class TransactionService {

  constructor(private http: HttpClient) { }

  addTransaction(buyerId: string, packetId: string, sellerId: string,time: Time): Observable<any> {
    return this.http.post(API_URL + 'transaction/add', {
      buyerId,
      packetId,
      sellerId,
      time
    }, httpOptions);
  }

}
