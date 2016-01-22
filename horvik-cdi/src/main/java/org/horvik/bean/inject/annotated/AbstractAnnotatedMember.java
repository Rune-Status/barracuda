/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.horvik.bean.inject.annotated;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import javax.enterprise.inject.spi.AnnotatedMember;
import javax.enterprise.inject.spi.AnnotatedType;

/**
 * Implementation of {@link AnnotatedMember} interface.
 * 
 * @version $Rev$ $Date$
 *
 * @param <X>
 *            declaring class
 */
abstract class AbstractAnnotatedMember<X> extends AbstractAnnotated implements AnnotatedMember<X> {
	/** Annotated type that owns this member */
	private final AnnotatedType<X> declaringType;

	/** Member type */
	protected final Member javaMember;

	AbstractAnnotatedMember(Type baseType, Member javaMember, AnnotatedType<X> declaringType) {
		super(baseType);

		if (declaringType == null) {
			throw new IllegalArgumentException("declaringType cannot be null");
		}

		this.javaMember = javaMember;
		this.declaringType = declaringType;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AnnotatedType<X> getDeclaringType() {
		return declaringType;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Member getJavaMember() {
		return javaMember;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isStatic() {
		return Modifier.isStatic(javaMember.getModifiers());
	}

	@Override
	protected Class<?> getOwningClass() {
		return declaringType.getJavaClass();
	}

	@Override
	protected Class<?> getDeclaringClass() {
		return javaMember.getDeclaringClass();
	}

	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append(",");
		builder.append("Java Member Name : " + javaMember.getName());

		return builder.toString();
	}
}