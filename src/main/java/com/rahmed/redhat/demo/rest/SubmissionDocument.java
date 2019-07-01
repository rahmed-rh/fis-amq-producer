/*
 * Copyright 2005-2016 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.rahmed.redhat.demo.rest;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class SubmissionDocument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6893550721134253577L;

	private Integer id;

	private String messageAttribute1;
	private String messageAttribute2;
	
	private String targetQueue;

	@ApiModelProperty(required = false, hidden = true)
	private String messageAttributehidden;

	public String getTargetQueue() {
		return targetQueue;
	}

	public void setTargetQueue(String targetQueue) {
		this.targetQueue = targetQueue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessageAttribute1() {
		return messageAttribute1;
	}

	public void setMessageAttribute1(String messageAttribute1) {
		this.messageAttribute1 = messageAttribute1;
	}

	public String getMessageAttribute2() {
		return messageAttribute2;
	}

	public void setMessageAttribute2(String messageAttribute2) {
		this.messageAttribute2 = messageAttribute2;
	}

	public String getMessageAttributehidden() {
		return messageAttributehidden;
	}

	public void setMessageAttributehidden(String messageAttributehidden) {
		this.messageAttributehidden = messageAttributehidden;
	}

	@Override
	public String toString() {

		return "[ id=" + id + ", messageAttribute1=" + messageAttribute1 + ", messageAttribute2=" + messageAttribute2
				+ ", targetQueue=" + targetQueue+ "]";
	}
}
