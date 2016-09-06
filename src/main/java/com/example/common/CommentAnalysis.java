package com.example.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentAnalysis {

	public static void main(String[] args) {
		/*String comment = "Pull Requests:\n"
				+"https://github.com/autotest/tp-libvirt/pull/831\n"
				+"https://github.com/avocado-framework/avocado-vt/pull/630\n"
				+"Auto Cases:\n"
				+"virtual_disks.multidisks.coldplug.single_disk_test.disk_driver_option.option_copy_on_read_on (requires root)\n"
				+"conf_file.libvirtd_conf.unix_sock\n"
				+"conf_file..disable_bypass_cache\n";*/

		String comment = "Pull Requests:  \r\nhttps://github.com/autotest/tp-libvirt/pull/831  \r\nhttps://github.com/avocado-framework/avocado-vt/pull/630  \r\nAuto Cases:  \r\nconf_file.libvirtd_conf.unix_sock  \r\nconf_file..disable_bypass_cache ";
		
		System.out.println(comment.matches("Pull(\\s)+Requests[\\s\\S]*") && comment.matches("[\\s\\S]*Auto(\\s)+Cases[\\s\\S]*"));

		String[] lines = comment.split("\n");
		for (String line : lines) {
			Pattern p=Pattern.compile("[^\\s]+\\.(.)*\\.(.)*"); 
			Matcher m=p.matcher(line); 
			if (m.find()) {
				System.out.println(m.group(0));
			}
		}

		System.out.println("=================================");
		boolean isCaseline = false;
		for (String line : lines) {
			if (line.matches("Auto(\\s)+Cases[\\S\\s]*")) {
				isCaseline = true;
				continue;
			}
			if (isCaseline) {
				System.out.println(line);
			}
		}
	}
}
