package com.jspiders.hibernate.email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="recylec_bin")
public class RecycleBin {
	  @Id
		private int id;
	    @Column(nullable = false, unique = false)
		private String senderName;
	    @Column(nullable = false, unique = false)
		private String receiverName;
	    @Column(nullable = false, unique = false)
		private String subject;

		public RecycleBin(int id, String senderName, String receiverName, String subject) {
			super();
			this.id = id;
			this.senderName = senderName;
			this.receiverName = receiverName;
			this.subject = subject;
		}

		public RecycleBin() {
			super();
		}
}
