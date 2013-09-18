/**
 * Copyright (C) 2013 Jakob Külzer (jakob.kuelzer@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.jakusys.jackhammer.cli.upload.handler.impl;

import de.jakusys.jackhammer.cli.path.Path;
import de.jakusys.jackhammer.cli.upload.handler.FileHandler;
import org.apache.jackrabbit.commons.JcrUtils;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import java.io.File;

/**
 * @author Jakob Külzer
 */
public class CreateDirectoryFileHandler implements FileHandler {

	private final Path path;

	private final File file;

	public CreateDirectoryFileHandler(Path path, File file) {
		this.path = path;
		this.file = file;
	}

	@Override
	public void handle(Node parentNode) {
		try {
			JcrUtils.getOrAddFolder(parentNode, path.toString());
		} catch (RepositoryException e) {
			throw new RuntimeException("Could not upload directory", e);
		}
	}

}
