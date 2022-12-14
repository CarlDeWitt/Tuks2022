(:~
 : Backup operations.
 :
 : @author Christian Grün, BaseX Team 2005-22, BSD License
 :)
module namespace dba = 'dba/databases';

import module namespace util = 'dba/util' at '../lib/util.xqm';

(:~ Sub category :)
declare variable $dba:SUB := 'database';

(:~
 : Drops a database backup.
 : @param  $name     name of database
 : @param  $backups  backup files
 : @return redirection
 :)
declare
  %updating
  %rest:GET
  %rest:path('/dba/backup-drop')
  %rest:query-param('name',   '{$name}')
  %rest:query-param('backup', '{$backups}')
function dba:backup-drop(
  $name     as xs:string,
  $backups  as xs:string*
) as empty-sequence() {
  dba:action($name, util:info($backups, 'backup', 'dropped'), function() {
    $backups ! db:drop-backup(.)
  })
};

(:~
 : Restores a database backup.
 : @param  $name    database
 : @param  $backup  backup file
 : @return redirection
 :)
declare
  %updating
  %rest:GET
  %rest:path('/dba/backup-restore')
  %rest:query-param('name',   '{$name}')
  %rest:query-param('backup', '{$backup}')
function dba:backup-restore(
  $name    as xs:string,
  $backup  as xs:string
) as empty-sequence() {
  dba:action($name, 'Database was restored.', function() {
    db:restore($backup)
  })
};

(:~
 : Performs a backup operation.
 : @param  $name    database
 : @param  $info    info string
 : @param  $action  updating function
 : @return redirection
 :)
declare %private %updating function dba:action(
  $name    as xs:string,
  $info    as xs:string,
  $action  as %updating function(*)
) as empty-sequence() {
  try {
    updating $action(),
    util:redirect($dba:SUB, map { 'name': $name, 'info': $info })
  } catch * {
    util:redirect($dba:SUB, map { 'name': $name, 'error': $err:description })
  }
};
