package druidsurv.cards.monkeys;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

public class DartMonkey extends AbstractEasyCard {
    public final static String ID = makeID("DartMonkey");
    // intellij stuff attack, enemy, basic, 6, 3,  , , , 

    public DartMonkey() {
        super(ID, 0, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY, "DartMonkeyIllustration");
        baseDamage = 4;
        tags.add(druidsurv.cards.cardvars.CardTags.DART);
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.setCardBack(cardSubType.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
    }

    @Override
    public void upp() {
        upgradeDamage(2);
    }
}