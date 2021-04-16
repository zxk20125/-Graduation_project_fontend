package cn.zxk.controller.qiantaiStaff.logistics;

import cn.zxk.mapper.TOrderMapper;
import cn.zxk.pojo.*;
import cn.zxk.service.TLogisticsSerivce;
import cn.zxk.service.TOrderSerivce;
import cn.zxk.service.TWaybillSerivce;
import cn.zxk.service.TdotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/qtStaff/logistics")
public class SLogisticsController {

    @Resource
    private TWaybillSerivce waSerivce;

    @Resource
    private TdotService dotSerivce;

    @Autowired
    private TOrderMapper orderMapper;

    @Resource
    private TLogisticsSerivce loSerivce;

    @RequestMapping("/logistics.do")
    private void xianshi(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
            throws ServletException, IOException, StringIndexOutOfBoundsException {

        TStaff staff = (TStaff) session.getAttribute("staff");
        req.setAttribute("staff", staff);

        req.getRequestDispatcher("/WEB-INF/qtStView/logistics/newlogistics.jsp").forward(req, resp);
    }

    @RequestMapping("/order.do")
    @ResponseBody
    private TWaybill orderxinxi(String id) {
        if (id.substring(0, 1).equals(" ")) {
            id = id.substring(1);
        }
        TWaybill waybill = waSerivce.selectAllByWbId(id);
        return waybill;
    }

    @RequestMapping("/dot.do")
    @ResponseBody
    private List<TDot> dot() {
//		id = id.substring(1);
//		TWaybill waybill = waSerivce.selectAllByWbId(id);

        List<TDot> dotselectAll = dotSerivce.dotselectAll();

        return dotselectAll;
    }

    @RequestMapping("/donew.do")
    @ResponseBody
    private int donew(TLogistics data, HttpSession session, HttpServletRequest req) {
        if (data.getWaybillId() == null) {
            return 0;
        }
        TStaff staff = (TStaff) session.getAttribute("staff");
        if (staff == null) {
            return 0;
        }
        if (data.getWaybillId().substring(0, 1).equals(" ")) {
            data.setWaybillId(data.getWaybillId().substring(1));
        }
        TWaybill waybill = waSerivce.selectAllByWbId(data.getWaybillId());
        TOrder order = new TOrder();
        order.setOrderId(waybill.getOrderId());
        order.setDotId(loSerivce.getDotId(data));
        orderMapper.updateByPrimaryKeySelective(order);
        req.setAttribute("staff", staff);
        data.setStaff(staff);
        data.setStaffId(staff.getStaffId());
        int i = loSerivce.logisticsInsert(data);
        return i;
    }
}
