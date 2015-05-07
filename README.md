Linkcollector
=============

[![Join the chat at https://gitter.im/EugeneViktorovich/linkcollector](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/EugeneViktorovich/linkcollector?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Plugin collects links from Skype chat and outputs them in some file.

Installation
------------

Download plugin by [link](http://sourceforge.net/projects/skypelinkcollector/files/?source=navbar)
and unzip the archive to any accessible directory.


Configuration
-------------

Configuration options are located in the file `conf/app.properties`.

<table>
  <tr>
    <td><b>collector.windowTitle</b></td>
    <td>chat name</td>
  </tr>
  <tr>
    <td><b>collector.fileName</b></td>
    <td>path to the output file</td>
  </tr>
</table>

Running
-------

    run.bat
    
Or, more familiar:

    linkcollector-x.x.exe

<b>NOTE:</b> Allow to use Skype

    Tools/Options.../Adavced/Manage other programms' access to Skype`
