package kr.co.moocl.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.moocl.service.FavService;

@RestController
@RequestMapping("/api")
public class MyPageFavController {
	
	@Autowired
	FavService favService;

	@RequestMapping(value="/listfavmovie", method=RequestMethod.GET)
	public List<String> showFavMovie(@RequestParam("userNo") int userId) {
		
		System.out.println("listFavMovie 진입");
		
		List<String> FavMovieList = favService.allFavMovie(userId);
		
		System.out.println("show me the list!");
		
		return FavMovieList;
		
	}
	
	@RequestMapping(value="/addfavmovie", method=RequestMethod.GET)
	public int addFavMovie(@RequestParam("userNo") int userId, @RequestParam("movieId") String movieId) {
		
		System.out.println("AddFavMovie 진입");
		
		int addFavMovie = favService.addFavMovie(userId, movieId);
		
		System.out.println("favmovie_controller :" + addFavMovie );
		
		return addFavMovie ;
	}
	
	@RequestMapping(value= "/delfavmovie", method=RequestMethod.GET)
	public int deleteFavMovie(@RequestParam("userNo") int userId, @RequestParam("movieId") String movieId) {
		
		System.out.println("deleteFavMovie 진입");
		
		int delFavMovie = favService.deleteFavMovie(userId, movieId);
		
		System.out.println("deletFavMovie 삭제완료 : " + delFavMovie);
		
		return delFavMovie;
	}
	
	@RequestMapping(value="/listfavpeople", method=RequestMethod.GET)
	public List<String> favPeopleList(@RequestParam("userNo") int userId) {
		
		System.out.println("FavPeopleList 진입");
		
		List<String> favpeopleList = favService.allFavpeople(userId);
		
		System.out.println("favpeople list성공 : " + favpeopleList);
		
		return favpeopleList;	
	}
	
	@RequestMapping(value="/addfavpeople", method=RequestMethod.GET)
	public int addFavPeople(@RequestParam("userNo") int userId, @RequestParam("personId") String personId) {
		
		System.out.println("AddFavPeople 진입");
		
		int add_favPeople = favService.insertfavPeople(userId, personId);
		
		System.out.println("AddFavPeople 완료 :" + add_favPeople );
		
		return add_favPeople ;
	}
	
	@RequestMapping(value= "/delfavpeople", method=RequestMethod.GET)
	public int deleteFavPeople(@RequestParam("userNo") int userId, @RequestParam("personId") String personId) {
		
		System.out.println("deleteFavPeople 진입");
		
		int del_Favperson = favService.deleteFavPeople(userId, personId);
		
		System.out.println("deleteFavPeople 삭제완료 : " + del_Favperson);
		
		return del_Favperson;
	}
	
}
	

