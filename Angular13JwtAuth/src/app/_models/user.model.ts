import { Transaction } from "./transaction.model";

import { Packet } from "./packet.model";

enum eRole { User, Admin }



export interface User {

  id: string;

  username: string;

  email: string;

  password: string; //chiedere se è di questo tipo

  ragSociale: string;

  role: eRole;

  wallet: number; //chiedere anche questo tipo

  packets: Packet;

  sell_transactions: Transaction;

  buy_transactions: Transaction;

}
