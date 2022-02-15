import { HttpClient, HttpErrorResponse } from '@angular/common/http';

import { Component, OnInit } from '@angular/core';

import { Packet } from '../_models/packet.model';

import { PacketService } from '../_services/packet.service';



@Component({

  selector: 'app-packet',

  templateUrl: './packet.component.html',

  styleUrls: ['./packet.component.css']

})

export class PacketComponent implements OnInit {

  public packets!: Packet[];
  public listPacketDTo!: Packet[];

  constructor(private packetService: PacketService) { }

  ngOnInit() {

    this.getAllPackets();

  }

  public getAllPackets(): void {

    this.packetService.getAllPackets().subscribe(
      (response: any) => {
        this.packets = response.listPacketDTo;
        console.log(this.packets);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}

  /*
  public getAllPackets(): void {

    this.packetService.getAllPackets().subscribe(
      (response: Packet[]) => {
        this.packets = response;
        data => this.packets = [data],
        console.log(this.packets);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}*/

/*
 *
  getusers() {
    this.http.get(`https://api.github.com/search/users?q=${this.input1.value}`)
        .map(response => response.json())
        .subscribe(
        data => this.users = [data], //Cast your object to array. that will do it.
        error => console.log(error)
        )


@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {
  content?: string;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getUserBoard().subscribe({
      next: data => {
        this.content = data;
      },
      error: err => {
        this.content = JSON.parse(err.error).message;
      }
    });
  }
}
*/
