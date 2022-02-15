import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Packet } from '../_models/packet.model';
import { PacketService } from '../_services/packet.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-packet',
  templateUrl: './update-packet.component.html',
  styleUrls: ['./update-packet.component.css']
})
export class UpdatePacketComponent implements OnInit {

  form: any = {
    title:null,
    description: null,
    quantity: null,
    type: null,
    price: null
  };

  
  ownerId!: string;

  packetUp!: Packet;
  packetId!: string | null;
  errorMessage = '';

  constructor(private packetService: PacketService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    //console.log(this.packetId);
    //this.packetId = this.packetFound.id;
    //this.ownerId = this.packetFound.owner.id;
    this.packetId = this.route.snapshot.queryParamMap.get('packetId');
    console.log(this.packetId);
    this.findPacketbyID(this.packetId);
    
  }

  onSubmit(): void {

    this.updatePacket(this.form);
  }

  public updatePacket(form: NgForm): void {

    const {title, description, quantity, price, type } = this.form;

    this.packetService.updatePacket(this.packetUp.id, this.packetUp.owner.id, title, description, quantity, price, type).subscribe(
      (response: void) => {
        console.log(response);
        alert("Operation completed!");
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  //restituisce packetUp
  public findPacketbyID(packetId: string|null): any {
    this.packetService.findPacketbyID(packetId).subscribe(
      (response: any) => {
        this.packetUp = response.packet;
        console.log(response.packet);  //metto response.packet in modo che in console mi mandi solo il pacchetto
      }
      //commentando questo non mi esce sempre ERROR 404 ogni volta che cerco di fare la ricerca
      ,
      (error: HttpErrorResponse) => {
        //alert(error.message);
      }

    );
  }

  public deletePacket(packetId: string): void {

    this.packetService.deletePacket(packetId).subscribe(
      (response: void) => {
        console.log(response);
        
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
