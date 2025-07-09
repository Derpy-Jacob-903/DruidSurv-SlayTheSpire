package druidsurv.cards.monkeys.druidic;

import basemod.patches.com.megacrit.cardcrawl.cards.AbstractCard.MultiCardPreview;
import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.PurgeField;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.cards.colorless.HeartOfThunderColorless;
import druidsurv.cards.colorless.Strike_Thorn;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.makeInHand;

public class ThunderDruid extends AbstractEasyCard {
    public final static String ID = makeID("ThunderDruid");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public ThunderDruid() {
        super(ID, 3, CardType.ATTACK, CardRarity.RARE, CardTarget.ALL_ENEMY, "ThunderDruid_CardArt");
        PurgeField.purge.set(this, true);
        baseDamage = 20;
        baseMagicNumber = magicNumber = 6;
        this.exhaust = true;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        MultiCardPreview.add(this, new Strike_Thorn());
        MultiCardPreview.add(this, new HeartOfThunderColorless());
        isMultiDamage = true;
        this.setCardBack(cardSubType.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        allDmg(AbstractGameAction.AttackEffect.LIGHTNING);
        makeInHand(new Strike_Thorn());
        makeInHand(new HeartOfThunderColorless());
    }

    @Override
    public void upp() {
        upgradeDamage(9);
    }
}