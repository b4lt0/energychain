package com.group1.energymanager.controller;

import com.group1.energymanager.request.PacketRequest;
import com.group1.energymanager.response.ListPacketResponse;
import com.group1.energymanager.response.PacketResponse;
import com.group1.energymanager.service.PacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    /*[Problems]
     * [SOLVED] 404 not answering to any request : added @Bean to main
     * */
@RestController
@RequestMapping("/packet")
public class PacketController {

    private final PacketService packetService;

    public PacketController(PacketService packetService) {
        this.packetService = packetService;
    }

    /*[Problems]
    * [SOLVED] 500 the request wasn't correctly processed : corrections in addPacket method
    * [SOLVED] jackson infinite nested objects problem : @JsonManagedReference
    * [SOLVED] http answer is right but doesn't show other params than id: because i created an object with just the id
    *
    * [IT WORKS] the objects are created
    * [NOT SOLVED] each object in the json shows nested objects
    * */
    @PostMapping("/add")
    private ResponseEntity<PacketResponse> createPacket(@RequestBody PacketRequest packetRequest) {
        return new ResponseEntity<PacketResponse>(packetService.addPacket(packetRequest), HttpStatus.OK);
    }

    /*[Problems]
     * [SOLVED] can't check because sql is not updating rows : restart mysqlbenchwork
     * [SOLVED] http answer is right but doesn't show other params than id: because i created an object with just the id
     * [SOLVED] the values are not updated correctly : merged with last problem in this list
     * [SOLVED] No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor and
     *      no properties discovered to create BeanSerializer
     *          (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) :
     *  try changing all LAZY to EAGER (don't know what I'm doing) : ahahah it doesn't compile, undo everything
     *  try spring.jackson.serialization.fail-on-empty-beans=false in application.properties :
     *      first add OK
     *      first update OK
     *      second update with same params creates a new instance with a different id
     *      next updates as the second but there's no more the instance with the original id
     *      ok i have to check the update method logic because is not working
     *  try removing the set id instruction :
     *      first add OK
     *      first update OK (but i see in the response that there's a new id, am I jealous?)
     *      second update OK (ok the object has a new id but i update it with the older one)
     *          no, when refreshing mysqlbw it shows a new id
     *  ok so the problem is that after the first update it starts updating also the id : merged with last problem in this list
     * [SOLVED] it works only for the first update
     *      after debugging i see that the program is working but after the correct update the id is being changed by sql maybe
     *      ok the problem was in my 'update' that I did deleting the old object and save the new one thus generating a new id
     *          but I needed just 'save' because jpa's save method works also for updating objects
     *
     * [IT WORKS] the values are being updated
     * [NOT SOLVED] each object in the json shows nested objects
     * */
    @PostMapping("/update")
    private ResponseEntity<PacketResponse> updatePacket(@RequestBody PacketRequest packetRequest) {
        return new ResponseEntity<PacketResponse>(packetService.updatePacket(packetRequest), HttpStatus.OK);
    }

    /*[Problems]
     * [SOLVED] 404 not answering request : the request parameter doesn't go in @GetMapping but in @RequestParam
     *
     * [IT WORKS] the packet has been found
     * */
    @GetMapping("/findbyID/")
    private ResponseEntity<PacketResponse> findbyId(@RequestParam("id") String packetID) {
        return new ResponseEntity<PacketResponse>(packetService.findPacketById(packetID), HttpStatus.OK);
    }

    /*[Problems]
     * [NOT SOLVED] sometimes the id is being changed and sometimes not idk why jpa reuses some ids
     *
     * [IT WORKS] the packet has been found
     * */

    @DeleteMapping("/delete/")
    private ResponseEntity<PacketResponse> deletePacket(@RequestParam("id") String packetID) {
        return new ResponseEntity<PacketResponse>(packetService.deletePacket(packetID), HttpStatus.OK);
    }

    /*[Problems]
     * [NOT SOLVED] sometimes the id is being changed and sometimes not idk why jpa reuses some ids
     * [NOT SOLVED] nested json entities
     *
     * [IT WORKS] the packet has been found
     * */
    @GetMapping("/all")
    private ResponseEntity<ListPacketResponse> findPackets() {
        return new ResponseEntity<ListPacketResponse>(packetService.getAllPackets(), HttpStatus.OK);
    }
}