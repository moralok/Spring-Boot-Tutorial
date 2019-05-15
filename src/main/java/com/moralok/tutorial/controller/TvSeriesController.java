package com.moralok.tutorial.controller;

import com.moralok.tutorial.pojo.TvSeries;
import com.moralok.tutorial.service.TvSeriesService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

@RestController
@RequestMapping("/tvseries")
public class TvSeriesController {

    public static final Log log = LogFactory.getLog(TvSeriesController.class);

    @Autowired
    TvSeriesService tvSeriesService;

    @GetMapping
    public List<TvSeries> getAll() {

        if (log.isTraceEnabled()) {
            log.trace("这是开始！");
        }

        if (log.isTraceEnabled()) {
            log.trace("getAll(); 被调用了");
        }

        List<TvSeries> list = tvSeriesService.getAllTvSeries();

        if (log.isErrorEnabled()) {
            log.error("这是结尾！");
        }

        return list;
    }

    @GetMapping("/{id}")
    public TvSeries getOne(@PathVariable int id) {
        if (log.isTraceEnabled()) {
            log.trace("getOne: " + id);
        }

        if (id == 101) {
            return createWestWorld();
        } else if (id == 102) {
            return createPoi();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @PostMapping
    public TvSeries insertOne(@Valid @RequestBody TvSeries tvSeries) {
        if (log.isTraceEnabled()) {
            log.trace("这里应该写新增 tvSeries 到数据库的代码，传递进来的参数是: " + tvSeries);
        }

        tvSeries.setId(9999);
        return tvSeries;
    }

    @PutMapping("/{id}")
    public TvSeries updateOne(@PathVariable int id, @RequestBody TvSeries tvSeries) {
        if (log.isTraceEnabled()) {
            log.trace("updateOne: " + id);
        }

        if (id == 101 || id == 102) {
            return createPoi();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteOne(@PathVariable int id, HttpServletRequest request, @RequestParam(value="delete_reason", required=false) String deleteReason) throws Exception {
        if (log.isTraceEnabled()) {
            log.trace("deleteOne: " + id);
        }

        Map<String, String> result = new HashMap<>();

        if (id == 101) {
            //TODO: 执行删除代码
            result.put("message", "#101被" + request.getRemoteAddr() + "删除（原因" + deleteReason + "）");
        } else if (id == 102) {
            //不能删除这个，RuntimeException 不如 org.springframework.security.access.AccessDeniedException 更合适

            throw new RuntimeException("#102不能被删除");
        } else {
            throw new ResourceNotFoundException();
        }

        return result;
    }

    @PostMapping(value = "/{id}/photos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void addPhoto(@PathVariable int id, @RequestParam("photo") MultipartFile imageFile) throws Exception {
        if (log.isTraceEnabled()) {
            log.trace("接受到文件：" + id + " 收到文件 " + imageFile.getOriginalFilename());
        }

        //保存文件
        FileOutputStream fos = new FileOutputStream("target/" + imageFile.getOriginalFilename());
        IOUtils.copy(imageFile.getInputStream(), fos);
        fos.close();

    }

    @GetMapping(value = "/{id}/icon", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getIcon(@PathVariable int id) throws Exception {
        if (log.isTraceEnabled()) {
            log.trace("getIcon(" + id + ")");
        }

        String iconFile = "src/test/resources/icon.jpeg";
        InputStream is = new FileInputStream(iconFile);
        return IOUtils.toByteArray(is);
    }

    private TvSeries createWestWorld() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.OCTOBER, 2, 0, 0);
        return new TvSeries(101, "WestWorld", 2, calendar.getTime());
    }

    private TvSeries createPoi() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2011, Calendar.SEPTEMBER, 22, 0, 0);
        return new TvSeries(102, "Person of Interest", 5, calendar.getTime());
    }
}
