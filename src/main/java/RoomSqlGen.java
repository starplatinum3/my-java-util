import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RoomSqlGen {

    void genEntity() {

    }

   static void rmPlus(){
        String diffStr="  import React from 'react';\n" +
                "+import React, { useRef } from 'react';\n" +
                " import { PageContainer } from '@ant-design/pro-layout';\n" +
                " import ProTable from '@ant-design/pro-table';\n" +
                "-import type { ProColumns } from '@ant-design/pro-table';\n" +
                "+import type { ProColumns, ActionType } from '@ant-design/pro-table';\n" +
                "+import { ModalForm, ProFormText } from '@ant-design/pro-form';\n" +
                "+import { Button, message } from 'antd';\n" +
                " import type { TableListItem } from './service';\n" +
                "-import { rule } from './service';\n" +
                "+import { rule, addRule } from './service';\n" +
                " \n" +
                " const NewPage: React.FC = () => {\n" +
                "+  const actionRef = useRef<ActionType>();\n" +
                "   const columns: ProColumns<TableListItem>[] = [\n" +
                "     {\n" +
                "       title: '规则名称',\n" +
                "@@ -17,13 +20,39 @@ const NewPage: React.FC = () => {\n" +
                "     },\n" +
                "   ];\n" +
                " \n" +
                "+  const addForm = (\n" +
                "+    <ModalForm onFinish={async (fields: TableListItem) => {\n" +
                "+      try {\n" +
                "+        await addRule(fields);\n" +
                "+        if (actionRef.current) {\n" +
                "+          actionRef.current.reload();\n" +
                "+        }\n" +
                "+        message.success('添加成功');\n" +
                "+        return true;\n" +
                "+      } catch (error) {\n" +
                "+        message.error('添加失败请重试！');\n" +
                "+        return false;\n" +
                "+      }\n" +
                "+    }} trigger={<Button type=\"primary\">新建</Button>}>\n" +
                "+      <ProFormText label=\"规则名称\" name=\"name\" required />\n" +
                "+      <ProFormText label=\"规则描述\" name=\"desc\" required />\n" +
                "+    </ModalForm>\n" +
                "+  );\n" +
                "+\n" +
                "   return (\n" +
                "     <PageContainer\n" +
                "       header={{\n" +
                "         title: '新的页面',\n" +
                "       }}\n" +
                "     >\n" +
                "-      <ProTable<TableListItem> columns={columns} request={rule} />\n" +
                "+      <ProTable<TableListItem>\n" +
                "+        actionRef={actionRef}\n" +
                "+        toolBarRender={() => {\n" +
                "+          return [addForm];\n" +
                "+        }}\n" +
                "+        columns={columns}\n" +
                "+        request={rule}\n" +
                "+      />\n" +
                "     </PageContainer>\n" +
                "   );\n" +
                " };";
        String[] split = diffStr.split("\n");

        for (String s : split) {
            if(s.startsWith("-")){
                continue;
            }
            if(s.startsWith("+")){
//                s.replaceFirst("+","");
                s=s.substring(1);

            }
            System.out.println(s);
        }
    }

    String entityNameMark = "#EntityName#";

    public  static String  genDao(String entityName) {
        String idType="Long";
//        String idType="long";
        String template = "package com.example.moments.dao;\n" +
                "\n" +
                "import androidx.room.Dao;\n" +
                "import androidx.room.Query;\n" +
                "\n" +
                "import com.example.moments.ssmemo.entity.#EntityName#;\n" +
                "\n" +
                "import java.util.List;\n" +
                "\n" +
                "@Dao\n" +
                "public interface #EntityName#Dao extends BaseDao<#EntityName#> {\n" +
                "\n" +
                "    \n" +
                "    @Query(\"SELECT * FROM \" + #EntityName#.TABLE_NAME)\n" +
                "    List<#EntityName#> getAll();\n" +
                "\n" +
                "    @Query(\"SELECT * FROM \" + #EntityName#.TABLE_NAME + \" where id = :id limit 1\")\n" +
                "    #EntityName# getById( "+idType+"  id);\n" +
                "\n" +
                "    @Query(\"SELECT * FROM \" + #EntityName#.TABLE_NAME + \" WHERE id IN (:ids)\")\n" +
                "    List<#EntityName#> loadAllByIds("+idType+"[] ids);\n" +
                "}\n";
//        String entityName="Content";
        String replacedStr = template.replace("#EntityName#", entityName);
//        System.out.println(template.replace("#EntityName#",entityName));
        System.out.println(replacedStr);
//        entityNameMark
        return replacedStr;
    }

    void genDaoFiles(){

        String outDir="G:\\dao";
//        File file = new File(outDir);
//        https://blog.csdn.net/weixin_34365042/article/details/114394498
//        try(new FileWriter(outDir,))
        String[] names = new String[]{"Comment", "Image", "Like", "Link"};
        for (String name : names) {
            Path path = Paths.get(outDir, name+".java");
//            path.
//            new File(path)
//            Path 建立 file java
//            Path 创建文件
            String daoStr = genDao(name);
            File file = path.toFile();
            try(FileWriter fileWriter=new FileWriter(file)) {
                fileWriter.write(daoStr);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            if (!file.exists()) {
//                file.mk
//            }
//            path.toString();
//            new FileWriter(path.toFile());
//            boolean mkdir = file.mkdir(name);

        }

        System.out.println("write here : "+outDir);
    }
    public static void main(String[] args) {
//        String  template="package com.example.moments.dao;\n" +
//                "\n" +
//                "import androidx.room.Dao;\n" +
//                "import androidx.room.Query;\n" +
//                "\n" +
//                "import com.example.moments.ssmemo.entity.#EntityName#;\n" +
//                "\n" +
//                "import java.util.List;\n" +
//                "\n" +
//                "@Dao\n" +
//                "public interface #EntityName#Dao extends BaseDao<#EntityName#> {\n" +
//                "\n" +
//                "    \n" +
//                "    @Query(\"SELECT * FROM \" + #EntityName#.TABLE_NAME)\n" +
//                "    List<#EntityName#> getAll();\n" +
//                "\n" +
//                "    @Query(\"SELECT * FROM \" + #EntityName#.TABLE_NAME + \" where id = :id limit 1\")\n" +
//                "    #EntityName# getById(long id);\n" +
//                "\n" +
//                "    @Query(\"SELECT * FROM \" + #EntityName#.TABLE_NAME + \" WHERE id IN (:ids)\")\n" +
//                "    List<#EntityName#> loadAllByIds(int[] ids);\n" +
//                "}\n";
//        String entityName="Content";
//        String  entityNameMark="#EntityName#";
//        System.out.println(template.replace("#EntityName#",entityName));


        rmPlus();
    }
}
