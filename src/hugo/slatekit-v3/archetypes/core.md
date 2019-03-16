---
title: "{{ replace .Name "-" " " | title }}"
date: {{ .Date }}
draft: true
---

# Overview
Describe this {COMPONENT_NAME} concisely in 2-3 sentences.
{{% break %}}

# Index
Table of contents for this page
<table class="table table-bordered table-striped">
    <tr>
        <td><strong>Section</strong></td>
        <td><strong>Component</strong></td>
        <td><strong>Description</strong></td>
    </tr>
    <tr>
        <td><strong>1</strong></td>
        <td><strong><a class="url-ch" href="core/cli#install">Install</a></strong></td>
        <td>Installation instructions and references to sources</td>
    </tr>
    <tr>
        <td><strong>2</strong></td>
        <td><strong><a class="url-ch" href="core/cli#requires">Requires</a></strong></td>
        <td>Lists all the Slate Kit and third-party dependencies</td>
    </tr>
    <tr>
        <td><strong>3</strong></td>
        <td><strong><a class="url-ch" href="core/cli#sample">Sample</a></strong></td>
        <td>Quick sample to show usage of the component</td>
    </tr>
    <tr>
        <td><strong>4</strong></td>
        <td><strong><a class="url-ch" href="core/cli#goals">Goals</a></strong></td>
        <td>Goals of this component and the problems it attempts to solve</td>
    </tr>
    <tr>
        <td><strong>5</strong></td>
        <td><strong><a class="url-ch" href="core/cli#concepts">Concepts</a></strong></td>
        <td>Core concepts to understand in this component</td>
    </tr>
    <tr>
        <td><strong>6</strong></td>
        <td><strong><a class="url-ch" href="core/cli#features">Features</a></strong></td>
        <td>List all the features supported</td>
    </tr>
    <tr>
        <td><strong>7</strong></td>
        <td><strong><a class="url-ch" href="core/cli#setup">Setup</a></strong></td>
        <td>Set up and configure this component for use</td>
    </tr>
    <tr>
        <td><strong>8</strong></td>
        <td><strong><a class="url-ch" href="core/cli#examples">Examples</a></strong></td>
        <td>In-depth examples of the supported features</td>
    </tr>
</table>
{{% section-end mod="core/cli" %}}

# Install
{{< highlight groovy >}}

    repositories {
        // other repositories
        maven { url  "http://dl.bintray.com/codehelixinc/slatekit" }
    }

    dependencies {
        // other dependencies ...

        compile 'com.slatekit:slatekit-{COMPONENT_ID}:0.9.9'
    }

{{< /highlight >}}
        
<table class="table table-bordered table-striped">
    <tr>
        <td><strong>jar</strong></td>
        <td>slatekit.{COMPONENT_ID}.jar</td>
    </tr>
    <tr>
        <td><strong>package</strong></td>
        <td>slatekit.{COMPONENT_ID}</td>
    </tr>
    <tr>
        <td><strong>source</strong></td>
        <td><a class="url-ch" href="https://github.com/code-helix/slatekit/tree/master/src/lib/kotlin/slatekit-app/src/main/kotlin/slatekit/app">slatekit.{COMPONENT_ID}</a></td>
    </tr>
    <tr>
        <td><strong>example</strong></td>
        <td><a class="url-ch" href="https://github.com/code-helix/slatekit/tree/master/src/lib/kotlin/slatekit-examples/src/main/kotlin/slatekit/examples/Example_App.kt">Example_{COMPONENT_ID}.kt</a> : Small reference example on setup/usage</td>
    </tr>
</table>
{{% section-end mod="core/cli" %}}

# Requires
This component uses the following other <strong>Slate Kit</strong> and/or third-party components.
<table class="table table-bordered table-striped">
    <tr>
        <td><strong>Component</strong></td>
        <td><strong>Description</strong></td>
    </tr>
    <tr>
        <td><a class="url-ch" href="core/results">Slate Kit - Results</a></td>
        <td>To model successes and failures with optional status codes</td>
    </tr>
    <tr>
        <td><a class="url-ch" href="utils/utils.html">Slate Kit - Common</a></td>
        <td>Common utilities for both android + server</td>
    </tr>
</table>
{{% section-end mod="core/cli" %}}

# Sample
{{< highlight kotlin >}}

    fun quick_sample() {
        
    }

{{< /highlight >}}
{{% section-end mod="core/cli" %}}

# Goals
<table class="table table-bordered table-striped">
    <tr>
        <td><strong>Goal</strong></td>
        <td><strong>Description</strong></td>
    </tr>
    <tr>
        <td><strong>1. Template</strong></td>
        <td>Provide template for any application 
        ( Console, Batch, CLI, Server )</td>
    </tr>
    <tr>
        <td><strong>2. Features</strong> </td>
        <td>Provide pre-built support commandline args, 
        config, logging, and more.</td>                     
    </tr>
    <tr>
        <td><strong>3. Standardized</strong></td>
        <td>Provide standardized setup, functionality and diagnostics</td>
        </td>                       
    </tr>
</table>
{{% section-end mod="core/cli" %}}

# Concepts
<table class="table table-bordered table-striped">
    <tr>
        <td><strong>Concept</strong></td>
        <td><strong>Description</strong></td>
    </tr>
    <tr>
        <td><strong>1. Template</strong></td>
        <td>Provide template for any application 
        ( Console, Batch, CLI, Server )</td>
    </tr>
    <tr>
        <td><strong>2. Features</strong> </td>
        <td>Provide pre-built support commandline args, 
        config, logging, and more.</td>                     
    </tr>
    <tr>
        <td><strong>3. Standardized</strong></td>
        <td>Provide standardized setup, functionality and diagnostics</td>
        </td>                       
    </tr>
</table>
{{% section-end mod="core/cli" %}}

# Features
<table class="table table-bordered table-striped">
    <tr>
        <td><strong>Feature</strong></td>
        <td><strong>Description</strong></td>
    </tr>
    <tr>
        <td><strong>1. Template</strong></td>
        <td>Provide template for any application 
        ( Console, Batch, CLI, Server )</td>
    </tr>
    <tr>
        <td><strong>2. Features</strong> </td>
        <td>Provide pre-built support commandline args, 
        config, logging, and more.</td>                     
    </tr>
    <tr>
        <td><strong>3. Standardized</strong></td>
        <td>Provide standardized setup, functionality and diagnostics</td>
        </td>                       
    </tr>
</table>
{{% section-end mod="core/cli" %}}

# Setup
todo
{{< highlight kotlin >}}

    fun setup() {
        
    }

{{< /highlight >}}
{{% section-end mod="core/cli" %}}


# Examples
todo

## Feature 1
{{< highlight kotlin >}}

    fun setup() {
        
    }

{{< /highlight >}}
{{% break %}}

## Feature 2
{{< highlight kotlin >}}

    fun setup() {
        
    }

{{< /highlight >}}
{{% break %}}

## Feature 3
{{< highlight kotlin >}}

    fun setup() {
        
    }

{{< /highlight >}}
{{% break %}}

{{% section-end mod="core/cli" %}}
