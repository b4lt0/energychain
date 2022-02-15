import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Packet } from '../_models/packet.model';
import { PacketService } from '../_services/packet.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  public deletePacket!: Packet;

  public packets!: Packet[];
  public listPacketDTO!: Packet[];

  public packetFound!: Packet;

  search = false;

  constructor(private packetService: PacketService, private router: Router) { }

  ngOnInit(): void {

    this.getAllPackets();

  }

  
  //onClick(packetId: string) {
  //  this._router.navigate(['/edit', packetId]);
  //}

  
  navigate1(packetId: string) {
    this.router.navigate(['/edit'], { queryParams: { packetId } });
  }

  navigate2(packetId: string) {
    this.router.navigate(['/info'], { queryParams: { packetId } });
  }
  
  

  public getAllPackets(): void {

    this.packetService.getAllPackets().subscribe(
      (response: any) => {
        this.packets = response.listPacketDTO;
        console.log(this.packets);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeletePacket(packetId: string): void {
    this.packetService.deletePacket(packetId).subscribe(
      (response: void) => {
        console.log(response);
        this.getAllPackets();
        alert("Packet deleted!");
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public findPacketbyID(packetId: string): any{
    this.packetService.findPacketbyID(packetId).subscribe(
      (response: any) => {
        this.packetFound = response.packet;
        this.search = true;
        console.log(response.packet);  //metto response.packet in modo che in console mi mandi solo il pacchetto
      }
      
       //commentando questo non mi esce sempre ERROR 404 ogni volta che cerco di fare la ricerca
      ,
      (error: HttpErrorResponse) => {
        //alert(error.message);
        this.search = false;
      }
      
    );
  }

  /*

  public onOpenModal(packet: Packet, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addPacketModal');
    }
    /*
    if (mode === 'edit') {
      this.editPacket = packet;
      button.setAttribute('data-target', '#updatePacketModal');
    }
    
    if (mode === 'delete') {
      this.deletePacket = packet;
      button.setAttribute('data-target', '#deletePacketModal');
    }
    container!.appendChild(button);
    button.click();
  }
  */


}
