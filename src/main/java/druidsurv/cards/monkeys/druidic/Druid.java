package druidsurv.cards.monkeys.druidic;

import basemod.patches.com.megacrit.cardcrawl.cards.AbstractCard.MultiCardPreview;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.cards.colorless.Strike_Thorn;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.makeInHand;

public class Druid extends AbstractEasyCard {
    public final static String ID = makeID("DruidCard");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public Druid() {
        super(ID, 2, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF, "DruidMonkey_CardArt");
        baseMagicNumber = magicNumber = 11;
        tags.add(CardTags.HEALING);
        MultiCardPreview.add(this, new Strike_Thorn());
        this.setCardBack(cardSubType.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new HealAction(p, p, 11));
        makeInHand(new Strike_Thorn()); // Add to the bottom of the action queue an action which adds a Shiv into your hand. (This is shorthanded by makeInHand).
        makeInHand(new Strike_Thorn());
    }

    @Override
    public void upp() {
        upgradeMagicNumber(5);
    }
}