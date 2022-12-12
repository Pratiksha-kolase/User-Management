package com.mobiloitte.com.dto;

import java.time.LocalDate;
import java.util.Date;

public class UserDto {

	   private Long user_id;
		private LocalDate userdob;
		private String emailadd;
		private String firstname;
		private String lastname;
		private Long mobnumber;
		private String password;
		private String username;
		public Long getUser_id() {
			return user_id;
		}
		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}
		public LocalDate getUserdob() {
			return userdob;
		}
		public void setUserdob(LocalDate userdob) {
			this.userdob = userdob;
		}
		public String getEmailadd() {
			return emailadd;
		}
		public void setEmailadd(String emailadd) {
			this.emailadd = emailadd;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public Long getMobnumber() {
			return mobnumber;
		}
		public void setMobnumber(Long mobnumber) {
			this.mobnumber = mobnumber;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
}
