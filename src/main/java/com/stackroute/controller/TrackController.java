package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exception.EmptyFieldException;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotExistsException;
import com.stackroute.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
@Api(value="Music Application")
public class TrackController {

    TrackService trackService;
    ResponseEntity responseEntity;

    @Autowired
    public TrackController(TrackService trackService) {

        this.trackService = trackService;
    }

    @ApiOperation(value="Track is saved")
    @ApiResponse(code=100,message = "get code message")
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException {


            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<Track>(track, HttpStatus.CREATED);

            return responseEntity;
    }

    @ApiOperation(value="All tracks are saved")
    @GetMapping("track")
    public ResponseEntity<?> displayTracks() {
        return new ResponseEntity<List<Track>>(trackService.displayTracks(), HttpStatus.OK);
    }

    @ApiOperation(value="Track is updated")
    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws EmptyFieldException {


            trackService.updateTrack(track);
            responseEntity = new ResponseEntity<String>("Updated", HttpStatus.CREATED);

            return responseEntity;
    }

    @ApiOperation(value="Track is deleted")
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> delTrack(@PathVariable("id") int id) throws TrackNotExistsException {


            trackService.delTrack(id);
            responseEntity = new ResponseEntity<String>("deleted successfully", HttpStatus.CREATED);

            return responseEntity;
    }

}

