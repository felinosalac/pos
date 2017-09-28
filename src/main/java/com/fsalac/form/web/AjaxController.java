package com.fsalac.form.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.fsalac.form.web.ajax.AjaxResponseBody;
import com.fsalac.form.web.ajax.SearchCriteria;
import com.fsalac.form.web.ajax.User;
import com.fsalac.form.web.ajax.Views;
import com.fsalac.form.web.dto.APIResponse;

@Controller
public class AjaxController {
	
	List<User> users;

	@RequestMapping(value = "search/api/getSearchResult", method = RequestMethod.POST)
	public ResponseEntity<APIResponse> getSearchResultViaAjax(@RequestBody SearchCriteria searchCriteria) {

		APIResponse apiResponse = new APIResponse();
		apiResponse.setStatus("success");
		apiResponse.setMessage("Ajax Response");

		// logic
		return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);

	}

	@RequestMapping(value = "search/test", method = RequestMethod.GET)
	public ResponseEntity<APIResponse> test() {

		APIResponse apiResponse = new APIResponse();
		apiResponse.setStatus("success");
		apiResponse.setMessage("Ajax Response");

		// logic
		return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);

	}

	@RequestMapping(value = "search/test2", method = RequestMethod.GET)
	public String test2() {

		System.out.println("test");
		return "test2";

	}

	@JsonView(Views.Public.class)
	@RequestMapping(value = "search/api/getSearchResult2", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponseBody testAjax(@RequestBody SearchCriteria search) {

		AjaxResponseBody result = new AjaxResponseBody();

		if (isValidSearchCriteria(search)) {
			List<User> users = findByUserNameOrEmail(search.getUsername(), search.getEmail());

			if (users.size() > 0) {
				result.setCode("200");
				result.setMsg("");
				result.setResult(users);
			} else {
				result.setCode("204");
				result.setMsg("No user!");
			}

		} else {
			result.setCode("400");
			result.setMsg("Search criteria is empty!");
		}

		// AjaxResponseBody will be converted into json format and send back to
		// the request.
		return result;

	}

	private boolean isValidSearchCriteria(SearchCriteria search) {

		boolean valid = true;

		if (search == null) {
			valid = false;
		}

		if ((StringUtils.isEmpty(search.getUsername())) && (StringUtils.isEmpty(search.getEmail()))) {
			valid = false;
		}

		return valid;
	}

	// Init some users for testing
	@PostConstruct
	private void iniDataForTesting() {
		users = new ArrayList<User>();

		User user1 = new User("mkyong", "pass123", "mkyong@yahoo.com", "012-1234567", "address 123");
		User user2 = new User("yflow", "pass456", "yflow@yahoo.com", "016-7654321", "address 456");
		User user3 = new User("laplap", "pass789", "mkyong@yahoo.com", "012-111111", "address 789");
		users.add(user1);
		users.add(user2);
		users.add(user3);

	}

	// Simulate the search function
	private List<User> findByUserNameOrEmail(String username, String email) {

		List<User> result = new ArrayList<User>();

		for (User user : users) {

			if ((!StringUtils.isEmpty(username)) && (!StringUtils.isEmpty(email))) {

				if (username.equals(user.getUsername()) && email.equals(user.getEmail())) {
					result.add(user);
					continue;
				} else {
					continue;
				}

			}
			if (!StringUtils.isEmpty(username)) {
				if (username.equals(user.getUsername())) {
					result.add(user);
					continue;
				}
			}

			if (!StringUtils.isEmpty(email)) {
				if (email.equals(user.getEmail())) {
					result.add(user);
					continue;
				}
			}

		}

		return result;

	}
	
	// delete user
	@JsonView(Views.Public.class)
	@RequestMapping(value = "admin/users/{id}/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public AjaxResponseBody deleteUser(@PathVariable("id") int id) {

		// userService.delete(id);
		// redirectAttributes.addFlashAttribute("css", "success");
		// redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		AjaxResponseBody result = new AjaxResponseBody();
		result.setCode("200");
		result.setMsg("Deleted!");

		return result;

	}
}
