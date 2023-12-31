package com.betting.karakoc.controller;

import com.betting.karakoc.model.dtos.BetRoundEntityDTO;
import com.betting.karakoc.model.dtos.GameEntityDTO;
import com.betting.karakoc.model.dtos.UserBetEntityDTO;
import com.betting.karakoc.model.real.UserEntity;
import com.betting.karakoc.model.requests.CreateBetRoundRequest;
import com.betting.karakoc.model.requests.CreateGameRequest;
import com.betting.karakoc.model.requests.PutGameRequestWithTwoTeams;
import com.betting.karakoc.service.repo.AdminService;
import com.betting.karakoc.service.repo.BetSummaryService;
import com.betting.karakoc.service.repo.MailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/bet/admin")
@AllArgsConstructor
@Tag(name = "Admin Controller")
@CrossOrigin(origins = "https://bettting.ey.r.appspot.com/")

public class AdminController {
    private final AdminService service;
    private final MailService mailService;
    @Operation(
            summary = "brings all user entities with pages. [0,x]")
    @GetMapping("/getAllUsers")
    @CrossOrigin(origins = "https://bettting.ey.r.appspot.com/")

    public Page<UserEntity> getAll(@RequestParam String token,@RequestParam int pageNumber){
        return service.getAllUsers(token,pageNumber);
    }

    @Operation(
            summary = "creating a new betround")
    @CrossOrigin(origins = "https://bettting.ey.r.appspot.com/")








    @PostMapping("/postBetRound")
    public BetRoundEntityDTO postBetRound(@RequestBody CreateBetRoundRequest request, @RequestParam String token){
        return service.createBetRound(request,token); // bir html işlemi
    }










    private final BetSummaryService betSummaryService;

    @Operation(
            summary = "brings all userbetrounds for given betrounds id")

    @GetMapping("/allBetsByGame")
    @CrossOrigin(origins = "https://bettting.ey.r.appspot.com/")
    public List<UserBetEntityDTO> getAllBetsByGame(@RequestParam Long betRoundId){
        return betSummaryService.getAllBetsByGame(betRoundId);
    }

    @Operation(
            summary = "brings a text like\nCONGRATS x, YOU WIN y GAME")
    @PostMapping("/summaryForAnyUser")
    @CrossOrigin(origins = "https://bettting.ey.r.appspot.com/")

    public String summaryBets(@RequestParam Long userBetRoundId, @RequestParam String token){
        return betSummaryService.summaryBetsForTwoTeams(userBetRoundId,token);
    }

    @Operation(
            summary = "creating a game for given betround")

    @PostMapping("/createGame")
    @CrossOrigin(origins = "https://bettting.ey.r.appspot.com/")


    public GameEntityDTO createGame(@RequestParam Long betroundId , @RequestBody CreateGameRequest request, @RequestParam int teamsSize, @RequestParam String token){
        return service.createGame(betroundId,request,teamsSize,token);
    }

    @Operation(
            summary = "brings all CREATED betrounds, after adding 13 game, betrounds status automaticly changes to PLANNED\nso this method just gives \"NOT FINISHED YET betrounds\"")

    @GetMapping("/getCreatedBetRounds")
    @CrossOrigin(origins = "https://bettting.ey.r.appspot.com/")

    public List<BetRoundEntityDTO> getCreatedBetRounds(@RequestParam String token){
        return service.getCreatedBetRounds(token);
    }

    @Operation(
            summary = "change the match score with gameId")
    @PutMapping("/putGame")
    @CrossOrigin(origins = "https://bettting.ey.r.appspot.com/")


    public GameEntityDTO putGame(@RequestBody PutGameRequestWithTwoTeams request, @RequestParam String token){
        return service.putGame(request,token);
    }


    @Operation(
            summary = "after all bets, finishes the betrounds manually.")
    @PutMapping("/endBetRound")
    @CrossOrigin(origins = "https://bettting.ey.r.appspot.com/")

    public BetRoundEntityDTO endBetRound(@RequestParam Long betroundId, @RequestParam String token){
        return service.endBetRound(betroundId,token);
    }

    @Operation(
            summary = "sends e-mail to all users participating in this betround")
    @GetMapping("/sendMailToParticipants")
    @CrossOrigin(origins = "https://bettting.ey.r.appspot.com/")

    public String mailSender(@RequestParam Long betroundId,@RequestParam String token){
        return mailService.mailSender2(token,betroundId);
    }
    //bu method neden get, herhalde kullandigim javamailsender bir veri get ediyor ve onu bekliyoruz. aslinda post olmasi lazim bende biliyorum ama post yapinca gondermedi.
    //bende get yaptim. denedim yani gercekten postu denedim.

    //update-yurdun internetinden kaynakli da olabilir. 8-10 defa denedim bi kere gonderdi en sonunda, o da @getmapping kullanirken gonderdi. birakayim boyle kalsin.
    //update2- try catchin icerisine aldim. artik internetin kotuyse veya x nedeninten oturu calismiyorsa bu metod, throw new exception ->bad internet connection. try again later.



}
