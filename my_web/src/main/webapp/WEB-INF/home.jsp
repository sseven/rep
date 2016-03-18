<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>HOME</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="/plugins/ui/frame/css/style.css" rel="stylesheet" />
</head>
<script type="text/javascript" src="/js/common/index.js"></script>
<script type="text/javascript" src="/js/jquery/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
	jQuery(function($) {
		$("#toggle-cat").click(function() {
			$("#toggle-client").removeClass("active");
			$("#client-filter-panel").hide();
			$(this).toggleClass("active");
			$("#cat-filter-panel").slideToggle(250);
			return false;
		});
		$("#toggle-client").click(function() {
			$("#toggle-cat").removeClass("active");
			$("#cat-filter-panel").hide();
			$(this).toggleClass("active");
			$("#client-filter-panel").slideToggle(250);
			return false;
		});
	});
	jQuery(function($) {
		$('#toggling').hide();
		var footerHeight = $('#footer').outerHeight(true);
		$('#footer-toggle').click(function() {
			$('#toggling').animate({
				'height' : 'toggle'
			}, 500);
			$(this).toggleClass('expanded');
			return false;
		});
	});
</script>
<body>
	<div id="fixed-header-slide">
		<div id="fixed-header-wrap">
			<div id="fixed-header">
				<div class="fixed-header-nav">
					<ul class="main-menu">
						<li><a href="" target="_blank">Home</a></li>
						<li><a href="" target="_blank">About
								Me</a></li>
						<li><a href="" target="_blank">Work</a></li>
						<li><a href="" target="_blank">Blog</a></li>
						<li>${LOGIN_USER.nickname } &nbsp; <span onclick="signout();" style="cursor: pointer;">sign out</span></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div id="header-wrap">
		<div id="header" style="display: ;">
			<h1 class="title_name">
				Framework Fixed Html with <span>CSS &amp; jQuery</span><small>by
					Sunflowa Media</small>
			</h1>
			<div id="main-nav">
				<ul class="main-menu">
					<li><a href="" target="_blank">Home</a></li>
					<li><a href="" target="_blank">About
							Me</a></li>
					<li><a href="" target="_blank">Work</a></li>
					<li><a href="" target="_blank">Blog</a></li>
					<li>${LOGIN_USER.nickname } &nbsp; <span onclick="signout();" style="cursor: pointer;">sign out</span></li>
				</ul>
			</div>
		</div>
	</div>

	<!-- Main -->
	<div id="main-wrap">
		<div id="container" style="display: ;">
			<h2>Here is a test title</h2>
			<h2>Satellite fell in south Pacific, not Canada</h2>
			<p>
				<img src="/img/bg/bg25.jpg" height="154" alt="" />
				WASHINGTON (AP) — The dead NASA satellite fell into what might be
				the ideal spot — part of the southern Pacific Ocean about as far
				from large land masses as you can get, U.S. space officials said
				Tuesday.
			</p>
			<p>New U.S. Air Force calculations put the 6-ton (5.4-metric ton)
				satellite's death plunge early Saturday thousands of miles
				(kilometers) from northwestern North America, where there were
				reports of sightings. Instead, it plunged into areas where remote
				islands dot a vast ocean.</p>

			<p>NASA says those new calculations show the 20-year-old
				satellite entered Earth's atmosphere generally above American Samoa.
				But falling debris as it broke apart did not start hitting the water
				for another 300 miles (480 kilometers) to the northeast, southwest
				of Christmas Island, just after midnight EDT Saturday.</p>

			<h2>Fugitive caught 41 years after hijacking</h2>

			<p>
				<img src="/img/bg/bg1.jpg" height="154" alt="" />
				NEWARK, <span class="yshortcuts" id="lw_1317187990_0">New
					Jersey</span> (AP) — A 1970s militant who escaped from a murder sentence
				in New Jersey and carried out one of the most brazen hijackings in
				U.S. history was captured in <span class="yshortcuts"
					id="lw_1317187990_3">Portugal</span> after more than 40 years as a
				fugitive, authorities said Tuesday. After decades of stagnancy,
				there was a sudden break in the case when police matched his
				fingerprint to a resident ID card.
			</p>
			<p>
				<span class="yshortcuts" id="lw_1317187990_2">George Wright</span>,
				68, was arrested Monday by <span class="yshortcuts"
					id="lw_1317187990_4">Portuguese authorities</span> in a town near
				Lisbon at the request of the U.S. government, said a member of the
				fugitive task force that had been searching for him for nearly a
				decade.
			</p>
			<p>Wright was convicted of the 1962 murder of a gas station owner
				in Wall, New Jersey. Authorities say Wright and three associates had
				already committed multiple armed robberies on Nov. 23, 1962, when he
				and another man shot and killed Walter Patterson, a decorated World
				War II veteran and father of two, during a robbery of the
				Collingswood Esso gas station in Wall.</p>
			<p>Wright received a 15- to 30-year sentence and had served eight
				years when he and three other men escaped from the Bayside State
				Prison farm in Leesburg, New Jersey, on Aug. 19, 1970.</p>
			<p>The FBI said Wright then became affiliated with an underground
				militant group, the Black Liberation Army, and lived in a "communal
				family" with several of its members in Detroit.</p>
			<p>On July 31, 1972, Wright, dressed as a priest and using the
				alias the Rev. L. Burgess, hijacked a Delta Air Lines flight from
				Detroit to Miami accompanied by three men, two men and three small
				children from his communal group, including Wright's companion and
				their 2-year-old daughter, according to Associated Press reports at
				the time.</p>
			<p>When the plane landed at the Miami airport, the hijackers
				demanded a $1 million ransom — the highest of its kind at the time —
				to free the 86 people on board. After an FBI agent delivered a
				70-pound (32-kilogram) satchel full of money — wearing only a pair
				of swim trunks, per the hijacker's instructions — the passengers
				were released, according to AP accounts.</p>
			<p>The hijackers then forced the plane to Boston, where an
				international navigator was taken aboard, and the group flew on to
				Algeria, where the hijackers sought asylum.</p>
			<p>The group was taken in by Eldridge Cleaver, the American
				writer and activist, who had been permitted by Algeria's Socialist
				government to open an office of the Black Panther Movement in that
				country in 1970, after the Algerian president at the time professed
				sympathy for what he viewed as worldwide liberation struggles.</p>
			<p>The hijackers had identified themselves to the passengers as a
				Black Panther group, police said at a news conference, according to
				AP reports at the time. They said the hijackers smoked marijuana
				continuously during the flight.</p>
			<p>Algerian officials returned the plane and the money to the
				U.S. at the request of the American government, and briefly detained
				the hijackers before letting them stay. Coverage of the hijackers'
				stay in Algeria said their movements were restricted, and the
				president ignored their calls for asylum and requests to return them
				the ransom money.</p>
			<p>The group eventually made its way to France, where Wright's
				associates were tracked down, arrested, tried and convicted in Paris
				in 1976. France refused to extradite them to the U.S., where they
				would have faced far longer prison sentences. According to news
				reports at the time, the defense hailed the light sentences they
				were given as "a condemnation of American racism" after the jury
				found "extenuating circumstances" in their actions, apparently
				agreeing with the defense's assertion that the hijacking had been
				motivated by "racial oppression in the United States."</p>
			<p>
				But Wright remained at large, and his case was among the top
				priorities when the New York-New Jersey Fugitive Task Force was
				formed in 2002, according to <span class="yshortcuts"
					id="lw_1317187990_5">Michael Schroeder</span>, a spokesman for the
				U.S. Marshals Service, who worked with <span class="yshortcuts"
					id="lw_1317187990_1">New Jersey</span>'s FBI and other agencies on
				the task force.
			</p>
			<p>The Department of Corrections brought along all its old escape
				cases nine years ago when the task force began operating, Schroeder
				said, and investigators started the case anew, never taking a
				prolonged break from working on it for the past nine years.</p>
			<p>They looked at reports from the 1970s, interviewed Wright's
				victims and the pilots of the plane he hijacked. They had
				age-enhanced sketches made and tried to track down any
				communications he may have made with family in the U.S.</p>
			<p>The address in Portugal was one of several on a list of places
				they wanted to check out. But Schroeder said there was nothing about
				it that made it seem especially promising. "It was another box to
				get checked, so to speak," he said.</p>
			<p>That changed last week, when details started falling into
				place with the help of authorities there.</p>
			<p>"They have a national ID registry," Schroeder said. "They
				pulled that. That confirmed his print matched the prints with the
				DOC. The sketch matched the picture on his ID card."</p>
			<p>By the weekend, U.S. authorities were on a plane to Portugal.
				And Monday, Portuguese police staking out his home found him.</p>
			<p>Schroeder said he has not been told what, if anything, Wright
				said when he was caught.</p>
			<p>Wright made an initial court appearance in Portugal on
				Tuesday, according to Justice Department Spokeswoman Laura Sweeney.
				He was arrested for purposes of extradition on the state of New
				Jersey's homicide charge, and would serve the remainder of his
				sentence on that charge if returned to the U.S.</p>

		</div>
		<!-- #container -->
	</div>

	<!-- Fixed Footer -->
	<div id="fixed-footer-wrap">
		<!-- Footer -->
		<div id="footer-wrap">
			<div id="footer">
				<a class="" href="#" id="footer-toggle"><span></span></a>
				<div id="toggling">
					<div class="border-top">
						<h3>
							Sunflowa Media - Green,Reliable,Funny Web Design.Hey, I'm Airos
							Chou.<br />I am a freelance web designer & graphic designer
							based in Shanghai, CN. I make Green Environment Protection
							website, accessible websites that are easy to use and easy for
							our life.<br />I'm in love with web standards xhtml/css.<br />If
							you have any questions or would like a quote, please don't
							hesitate to drop me a line.
						</h3>
					</div>
				</div>
			</div>
		</div>
		<div id="fixed-footer">
			<p>
				<strong>Say Hello</strong>: Check out <a href=""
					target="_blank">Sunflowa Media Blog</a>, for more tutorials! <span
					class="follow">And you may also <a
					href="" target="_blank">@me</a> on sina twitter
				</span>
			</p>
		</div>
	</div>
</body>
</html>
