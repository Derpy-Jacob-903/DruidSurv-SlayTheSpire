package druidsurv.cards.monkeys;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.*;

public class MonkeyInvestigator extends AbstractEasyCard {
    public final static String ID = makeID("Investigator");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public MonkeyInvestigator() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY, "MonkeyInvestigator_CardArt");
        baseDamage = 7;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.setCardBack(cardSubType.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractCard eligibleCardsList = returnTrulyRandomPrediCardInCombat(c -> c.hasTag(druidsurv.cards.cardvars.CardTags.BLOON));
        makeInHand(eligibleCardsList);
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
    }

    @Override
    public void upp() {
        upgradeDamage(4);
    }
}