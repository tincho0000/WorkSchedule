package com.workschedule.app.controllers;

import com.workschedule.app.models.entity.*;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/planning")
public class PlanningController {
	@GetMapping(value="")
	public String savePlanning(@ModelAttribute Planificacion planning, BindingResult errors, Model model) {
		return "planning/new-planning";
	}

		// logic to process input data
}
