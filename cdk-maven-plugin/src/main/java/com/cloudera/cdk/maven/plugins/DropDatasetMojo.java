/**
 * Copyright 2013 Cloudera Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cloudera.cdk.maven.plugins;

import com.cloudera.cdk.data.DatasetRepository;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Delete a dataset and its metadata.
 *
 * @deprecated will be removed in 0.10.0; use delete-dataset instead.
 */
@Deprecated
@Mojo(name = "drop-dataset", requiresProject = false)
public class DropDatasetMojo extends AbstractDatasetMojo {

  private static final Logger logger = LoggerFactory.getLogger(DropDatasetMojo.class);

  /**
   * The name of the dataset to drop.
   */
  @Parameter(property = "cdk.datasetName", required = true)
  private String datasetName;

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {
    logger.warn("CDK drop-dataset is deprecated -- please use delete-dataset");
    DatasetRepository repo = getDatasetRepository();
    repo.delete(datasetName);
  }
}
