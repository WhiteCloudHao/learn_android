import Dexie from 'dexie';

export const db = new Dexie('myDatabase');
db.version(1).stores({
    alarms: '++id,title,description,date,time,repeat', // Primary key and indexed props
});
