package kr.co.moocl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.moocl.dao.FavDao;

@Service
public class FavService {
	
	@Autowired
	FavDao favDao;

	public List<String> allFavMovie(int userId) {
		
		System.out.println("fav_MOVIE_List Service 진입");
		
		List<String> getfavMoivie = favDao.getFavMovielist(userId);
		
		System.out.println("getfavMoivie : " + getfavMoivie);
		
		return getfavMoivie;
	}
	
	
	public int addFavMovie(int userId, String movieId) {
		System.out.println("addFavMovie service진입");
		
		int insertFavMovie = favDao.insertFmovie(userId, movieId);
		
		System.out.println("add movie service 완료" + insertFavMovie);
		
		return insertFavMovie;
	}


	public int deleteFavMovie(int userId, String movieId) {
		System.out.println("deleteFavMovie service 진입");
		
		int removeFavMovie = favDao.deleteFavM(userId, movieId);
		
		System.out.println("deleteFavMovie service :" + removeFavMovie);
		
		return removeFavMovie;
	}


	public List<String> allFavpeople(int userId) {
		
		System.out.println("fav_PEOPLE_list Service 진입");
		
		List<String> showFpeoplelist = favDao.showfavpeoplelist(userId);
		
		System.out.println("getfavMoivie : " + showFpeoplelist);
		
		return showFpeoplelist;
	}


	public int insertfavPeople(int userId, String personId) {
		
		System.out.println("insertfavPeople service진입");
		
		int insert_favPerson = favDao.addfavperson(userId, personId);
		
		System.out.println("insert favPeople service 완료" + insert_favPerson);
		
		return insert_favPerson;
	}


	public int deleteFavPeople(int userId, String personId) {
		
		System.out.println("deleteFav_person service 진입");
		
		int delete_fperson = favDao.delFavPerson(userId, personId);
		
		System.out.println("deleteFav_person service 삭제완료 :" + delete_fperson);
		
		return delete_fperson;
	}

}
