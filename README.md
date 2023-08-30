这个案例实现了一项基本的新增与修改功能，但逻辑较复杂，觉得还是应该记录一下的！  
比如数据库有3条记录，name分别为Aimer、milet、ikura，
而此时前端又传递过来3条记录，name分别为milet、ikura、yorushika，
要求实现按照name实现修改或新增数据：如果数据库已经存在name的记录，则修改数据，否则新增数据，并把前端传递过来的不存在的name记录删除掉。
***
比如下图中，数据库原本有Aimer、milet、ikura，此时前端传来milet、ikura、yorushika，需要删除Aimer，修改milet、ikura，新增yorushika
![1781ba894a8be6c6975c3f6a22679cd](https://github.com/threeshui1024/invoice/assets/85988748/65759a1b-dc13-4b50-a523-2ba5de67b8db)
