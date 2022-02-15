import { Transaction } from "./transaction.model";

import { User } from "./user.model";

enum Type { Green, Other }



export interface Packet {

  id: string;

  title: string;

  owner: User;

  description: string;

  quantity: number;

  price: number;

  type: Type;

  transactions: Transaction[];

}
