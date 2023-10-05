package Brent_Cubbage.QuickPollApplicationLab.Controller;

import Brent_Cubbage.QuickPollApplicationLab.domain.Poll;
import Brent_Cubbage.QuickPollApplicationLab.repositories.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
public class PollController {


    private PollRepository pollRepository;

@Autowired
    public PollController(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }


    @GetMapping(value = "/polls")
    public ResponseEntity<Iterable<Poll>> getAllPolls(){
    Iterable<Poll> allPolls = pollRepository.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(allPolls);
    }

    @GetMapping(value = "/polls/{id}")
    public ResponseEntity<?> getPoll(@PathVariable Long id){
    Poll poll = pollRepository.findById(id).get();
    return new ResponseEntity<>(poll, HttpStatus.OK);
    }

    @PostMapping(value = "/polls")
    public ResponseEntity<?> createPoll(@RequestBody Poll poll){

    URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(poll.getId()).toUri();
    poll = pollRepository.save(poll);
    HttpHeaders head = new HttpHeaders();
    head.setLocation(newPollUri);
    return new ResponseEntity<>(head, HttpStatus.CREATED);
    }

    @PutMapping(value = "/polls/{id}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long id){
    poll = pollRepository.save(poll);
    return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping(value = "/polls/{id}")
    public ResponseEntity<?> deletePoll(@PathVariable Long id){
    Poll deletePoll = pollRepository.findById(id).get();
    pollRepository.delete(deletePoll);
    return new ResponseEntity<>(HttpStatus.OK);
    }


}
