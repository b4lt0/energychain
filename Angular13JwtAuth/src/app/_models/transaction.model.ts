import { Time } from "@angular/common";

import { Timestamp } from "rxjs";

import { Packet } from "./packet.model";

import { User } from "./user.model";



export interface Transaction {

  id: string;

  sellerId: User;

  buyerId: User;

  packet: Packet;

  time: Time;

}
